import React from 'react';
import { Link } from 'react-router-dom';
import img from '../../img/samsung-small.jpg';

const AdminGreetingComponent = ({ id, image, title, onDelete }) => (
  <tbody>
    <tr>
      <th scope="row">{id}</th>
      <td>
        <img
          src={img}
          className="card-img-top"
          style={{ width: 50, height: 50 }}
          alt={title}
        />
      </td>
      <td>
        <Link to={`/admin/greetings/${id}`}>{title} </Link>
      </td>
      <td>
        <button className="btn btn-danger" onClick={() => onDelete(id)}>
          Delete greeting
        </button>
      </td>
    </tr>
  </tbody>
);

export default AdminGreetingComponent;
