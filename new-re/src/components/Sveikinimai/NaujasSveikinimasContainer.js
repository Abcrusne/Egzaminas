import React, { Component } from 'react';
import axios from 'axios';
import NaujasSveikinimasComponent from './NaujasSveikinimasComponent';
import myUrl from '../../AppConfig';
export default class NaujasSveikinimasContainer extends Component {
  constructor() {
    super();
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

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    console.log(this.state);
    axios
      .post(`${myUrl}/api/greetings`, this.state)
      .then((response) => {
        this.props.history.push('/admin');
      })
      .catch((error) => {
        console.log(error);
      });
  };

  render() {
    return (
      <main className="container pt-5">
        <NaujasSveikinimasComponent
          handleChange={this.handleChange}
          handleSubmit={this.handleSubmit}
          name={this.state.name}
          text={this.state.text}
          image={this.state.image}
          date={this.state.date}
          type={this.state.type}
          audio={this.state.audio}
        />
      </main>
    );
  }
}
