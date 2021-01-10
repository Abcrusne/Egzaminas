import React, { Component } from 'react';
import axios from 'axios';
import { withRouter } from 'react-router';
import myUrl from '../../AppConfig';
import FormComponent from './FormComponent';

 class FormContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      text: '',
      image: '',
      name: '',
      date: '',
      type: '',
      audio: '',
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
            name: res.data.name || '',
            text: res.data.text || '',
            image: res.data.image || '',
            audio: res.data.type || '',
            type: res.data.type || '',
            date: res.data.date || ''
           
          })
        )
        .catch((err) => console.log(err));
    }
  }
  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  handleSubmit = (e) => {
    //   e.preventDefault();
    //   console.log(this.state);
    //   axios
    //     .post(`${myUrl}/api/greetings`, this.state)
    //     .then((res) => {
    //       this.props.history.push('/greetings');
    //     })
    //     .catch((error) => {
    //       console.log(error);
    //     });
    // };
    e.preventDefault();

    if (this.state.id > 0) {
      axios
        .put(`${myUrl}/api/greetings/${this.state.id}`, {
          id: this.state.id,
          text: this.state.text,
          name: this.state.name,
          image: this.state.image,
          audio: this.state.audio,
          type: this.state.type,
          date: this.state.date,
        })
        .then(() => this.props.history.push('/admin/greetings'));
    } else {
      axios
        .post(`${myUrl}/api/greetings`, {
          id: this.state.id,
          text: e.target.text.value,
          name: e.target.name.value,
          image: e.target.image.value,
          audio: e.target.audio.value,
          type: e.target.type.value,
          date: e.target.date.value,
        })
        .then(() => this.props.history.push('/admin/greetings'));

      this.setState({
        text: '',
        name: '',
        image: '',
        audio: '',
        type: '',
        date: '',
      });
    }
  };

  render() {
    return (
      <div className="container">
        <FormComponent
          handleSubmit={this.handleSubmit}
          handleChange={this.handleChange}
          {...this.state}
        />
      </div>
    );
  }
}

export default withRouter(FormContainer );