import React from 'react';
import { Link } from 'react-router-dom';
import img from '../../img/samsung-big.jpg';

const GreetingCardComponent = ({ id, itemImg, ...otherProps }) => {
  console.log('Greeting Card: ', id);
  //const { title, description, price, quantity } = otherProps;
  return (
    <div className="card col-12 col-md-6 col-lg-4 my-3">
      <img src={img} className="card-img-top" alt={otherProps.title} />
      <div className="card-body ">
        <h5 className="card-title">Title: {otherProps.title}</h5>
        <p className="card-text">Text: {otherProps.text}</p>
        <p>
          Name: {otherProps.firstname} {otherProps.lastName}
        </p>
        <p className="card-quantity">Date: {otherProps.date}</p>
        <Link to={`/greeting/${id}`} className="btn btn-dark">
          More info
        </Link>
      </div>
    </div>
  );
};
export default GreetingCardComponent;
