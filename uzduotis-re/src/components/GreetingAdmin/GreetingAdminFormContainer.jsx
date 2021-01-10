import React, { Component } from 'react';
import axios from 'axios';
import { withRouter } from 'react-router';
import myUrl from '../../AppConfig';
import GreetingAdminFormComponent from './GreetingAdminFormComponent';

class GreetingAdminFormContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      audio: '',
      image: '',
      name: '',
      text: '',
      date: '',
      type: '',
      id: 0,
    };
  }

  componentDidMount() {
    if (this.props.match.params.id > 0) {
      axios

        .get(`${myUrl}/api/greetings/${this.props.match.params.id}`)
        .then((res) =>
          this.setState({
            id: res.data.id || '',
            audio: res.data.audio || '',
            text: res.data.text || '',
            image: res.data.image || '',
            date: res.data.date || '',
            type: res.data.type || '',
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
          name: this.state.name,
          audio: this.state.audio,
          type: this.state.type,
          date: this.state.date,
        })
        .then(() => this.props.history.push('/admin/greetings'));
    } else {
      axios
        .post(`${myUrl}/api/greetings`, {
          text: e.target.text.value,
          id: this.state.id,
          image: e.target.image.value,
          name: e.target.name.value,
          audio: e.target.audio.value,
          type: e.target.type.value,
          date: e.target.type.value,
        })
        .then(() => this.props.history.push('/admin/greetings'));

      this.setState({
        audio: '',
        image: '',
        name: '',
        text: '',
        date: '',
        type: '',
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
