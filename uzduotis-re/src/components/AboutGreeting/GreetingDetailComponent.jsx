import React from 'react';
import { Link } from 'react-router-dom';

import img from '../../img/samsung-big.jpg';

const GreetingDetailsComponent = ({
  title,
  image,
  date,
  text,
  firstname,
  lastname,
  
  // addToCart,
}) => {
  return (
    <div>
      <div className="media">
        <img
          className="align-self-start mr-3"
          src={img}
          alt={title}
          style={{
            height: '25rem',
          }}
        />
        <div className="media-body mt-3">
          <h5 className="mt-0">{title}</h5>
          <p>Text: {text}</p>
          <p>
            Name: {firstname} {lastname}{' '}
          </p>
          <p>Date: {date} </p>
        </div>
      </div>
      <div className="row ml-5 mt-3">
        {/* {currentUser !== undefined ? (
          <button className="btn btn-primary mr-1" onClick={addToCart}>
            Add to cart
          </button>
        ) : (
          <h5>You need to login to add products to your cart.</h5>
        )} */}
        <Link to={'/'} className="btn btn-outline-dark">
          Go back
        </Link>
      </div>
    </div>
  );
};

export default GreetingDetailsComponent;
