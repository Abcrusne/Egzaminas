import React, { Component } from 'react';
import myUrl from '../../AppConfig';
import axios from 'axios';
import ItemCardComponent from './ItemCardComponent';
import SearchBar from '../Search/SearchBar';

class ItemListContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      greetings: [],
      searchQuery: '',
    };
  }

  componentDidMount() {
    console.log("Item saraso containeris componentDidMount")
    axios
      .get(`${myUrl}/api/greetings`)
      .then(res => {
        this.setState({ greetings: res.data });
      })
      .catch((err) => {
        console.log(err);
      });
  }

  // handleSearch = (e) => {
  //   const name = e.currentTarget.value;
  //   console.log(name);

  //   this.setState({ searchQuery: name });
  // };

  render() {
    const { data } = this.state.greetings;

    if (data) {
      return (
        <div className="container mt-4">
          <div className="row">
            {/* <SearchBar
              value={this.state.searchQuery}
              onChange={this.handleSearch}
            /> */}
          </div>
          <div className="row d-flex justify-content-center">
            {data.map(({ id, ...otherProps }) => (
              <ItemCardComponent key={id} id={id} {...otherProps} />
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
export default ItemListContainer;
