import React from 'react';
import { Link } from 'react-router-dom';
import img1 from '../../img/img1.png';
import img2 from '../../img/img2.jpg';
import img3 from '../../img/img3.jpg';

const ItemCardComponent = ({ id, name, image, ...otherProps }) => {
  console.log('Greeting Card: ', id);
  const imgSrc = image === 'img1' ? img1 : image === 'img2' ? img2 : img3;
  return (
    <div className="card col-12 col-md-6 col-lg-4 my-3">
      <img src={imgSrc} className="card-img-top" alt={name} style={{
            height: '10rem',
          }} />
      <div className="card-body ">
        <h5 className="card-name">Name: {name}</h5>
        <p className="card-text">Text: {otherProps.text}</p>
        <p>Type: {otherProps.type}</p>
        <p className="card-date">Date: {otherProps.date}</p>
        
        <Link to={`/greeting/${id}`} className="btn btn-dark">
          More info
        </Link>
      </div>
    </div>
  );
};
export default ItemCardComponent;
