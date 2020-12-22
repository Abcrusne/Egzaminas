import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import myUrl from '../../AppConfig';
import img from '../../img/samsung-big.jpg';

import AdminGreetingComponent from './AdminGreetingComponent';

class AdminListContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      greetings: [],
    };
  }

  componentDidMount() {
    axios
      .get(`${myUrl}/api/greetings`)
      .then((greeting) => {
        this.setState({ greetings: greeting });
      })
      .catch((err) => {
        console.log(err);
      });
  }
  deleteItem = (id) => {
    axios
      .delete(`${myUrl}/api/greetings/${id}`)
      .then((response) => {
        this.setState({ greeting: response.data });
      })
      .catch((error) => {
        console.log(error);
      });
  };

  render() {
    const { data } = this.state.greetings;
    if (data) {
      console.log(data);
      return (
        <div className="container mt-5">
          <Link to={`/admin/greetings/new`} className="btn btn-primary mb-5">
            Add new greeting
          </Link>
          <table className="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Image</th>
                <th scope="col">Title</th>
                <th scope="col"> </th>
              </tr>
            </thead>
            {data.map(({ id, image, ...otherProps }) => (
              <AdminGreetingComponent
                key={id}
                id={id}
                image={img}
                onDelete={this.deleteItem}
                {...otherProps}
              />
            ))}
          </table>
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
export default AdminListContainer;
