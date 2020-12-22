import React, { Component } from 'react';
import axios from 'axios';
import { withRouter } from 'react-router';
import myUrl from '../../AppConfig';
import GreetingAdminFormComponent from './GreetingAdminFormComponent';

class GreetingAdminFormContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: '',
      image: '',
      text: '',
      firstname: '',
      lastname: '',
      id: 0,
    };
  }

  componentDidMount() {
    if (this.props.match.params.id > 0) {
      axios
        //.get('https://itpro2017.herokuapp.com/api/products')
        .get(`${myUrl}/api/greetings/${this.props.match.params.id}`)
        .then((res) =>
          this.setState({
            id: res.data.id || '',
            title: res.data.title || '',
            text: res.data.text || '',
            image: res.data.image || '',
            firstname: res.data.firstname || '',
            lastname: res.data.lastname || '',
          })
        )
        .catch((err) => {
          console.log(err);
        });
    }
  }

  handleSubmit = (e) => {
    e.preventDefault();

    if (this.state.id > 0) {
      axios
        .put(`${myUrl}/api/greetings/${this.state.id}`, {
          text: this.state.text,
          id: this.state.id,
          image: this.state.image,
          firstname: this.state.firstname,
          lastname: this.state.lastname,
          title: this.state.title,
        })
        .then(() => this.props.history.push('/admin/greetingss'));
    } else {
      axios
        .post(`${myUrl}/api/greetings`, {
          text: e.target.text.value,
          id: this.state.id,
          image: e.target.image.value,
          firstname: e.target.firstname.value,
          lastname: e.target.lastname.value,
          title: e.target.title.value,
        })
        .then(() => this.props.history.push('/admin/greetings'));

      this.setState({
        title: '',
        image: '',
        text: '',
        firstname: '',
        lastname: '',
      });
    }
  };

  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  render() {
    return (
      <GreetingAdminFormComponent
        handleSubmit={this.handleSubmit}
        handleChange={this.handleChange}
        {...this.state}
      />
    );
  }
}

export default withRouter(GreetingAdminFormContainer);
