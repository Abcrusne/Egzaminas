import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import { withRouter } from 'react-router';
import myUrl from '../../AppConfig';
import ItemAdminComponent from './ItemAdminComponent';

 class ItemAdminContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      greetings: [],
    };
  }
  // componentDidMount = () => {
  //   axios
  //     .get(`${myUrl}/api/greetings`)
  //     .then((res) => this.setState({ greetings: res.data }))
  //     .catch((err) => console.log(err));
  // };

  // deleteItem = (e) => {
  //   e.preventDefault();
  //   axios
  //     .delete(`${myUrl}/api/greetings/${e.target.value}`)
  //     .then(() => {
  //       axios
  //         .get(`${myUrl}/api/greetings/`)
  //         .then((res) => this.setState({ greetings: res.data }));
  //     })
  //     .catch((err) => console.log(err));
  // };
  componentDidMount() {
    axios
      .get(`${myUrl}/api/greetings`)
      .then((response) => {
        this.setState({ greetings: response.data });
      })
      .catch((err) => {
        console.log(err);
      });
  }
  deleteItem = (id) => {
    
    axios
      .delete(`${myUrl}/api/greetings/${id}`)
      .then((greeting) => {
        this.setState({ greetings: greeting.data });
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
        <div>
          <Link to={`/admin/greetings/new`} className="btn btn-primary mb-5">
            Add new item
          </Link>
        </div>
        <div>
          <table className="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Image</th>
                <th scope="col">Name</th>
                <th scope="col"> </th>
              </tr>
            </thead>
            {data.map(({ id, image, ...otherProps }) => (
            
                <ItemAdminComponent
                  key={id}
                  id={id}
                  deleteItem={this.deleteItem}
                  {...otherProps}
                />
              
            ))}
          </table>
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

export default withRouter( ItemAdminContainer);