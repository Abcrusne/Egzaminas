import React, { Component } from 'react';
//import React, { useEffect, useState } from 'react';
import axios from 'axios';
import GreetingCardComponent from './GreetingCardComponent';
import img from '../../img/samsung-big.jpg';
import myUrl from '../../AppConfig';
import SearchBar from '../Search/SearchBar';

class GreetingListContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      greetings: {},
    };
  }

  componentDidMount() {
    axios
      .get(`${myUrl}/api/greetings?title=`)
      .then((greetings) => {
        this.setState({ greetings });
      })
      .catch((err) => {
        console.log(err);
      });
  }
  handleChange = (e) => {
    e.preventDefault();
    axios
      .get(`${myUrl}/api/greetings?title=${e.target.value}`)
      .then((greetings) => {
        this.setState({ greetings: greetings });
      })
      .catch((error) => {
        console.log(error);
      });
  };

  render() {
    const { data } = this.state.greetings;

    if (data) {
      return (
        <div className="container mt-4">
          <div className="row">
            <SearchBar onChange={this.handleChange} />
          </div>
          <div className="row d-flex justify-content-center">
            {data.map(({ id, ...otherProps }) => (
              <GreetingCardComponent
                key={id}
                id={id}
                itemImg={img}
                {...otherProps}
              />
            ))}
          </div>
        </div>
      );
    } else {
      return (
        <div className="text-center">
          <div className="spinner-border m-5 text-dark" role="status">
            <span className="sr-only">Loading...</span>
          </div>
        </div>
      );
    }
  }
}
export default GreetingListContainer;
