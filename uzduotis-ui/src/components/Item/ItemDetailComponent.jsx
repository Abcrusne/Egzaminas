import React from 'react';
import { Link } from 'react-router-dom';
import img1 from '../../img/img1.png';
import img2 from '../../img/img2.jpg';
import img3 from '../../img/img3.jpg';

const ItemDetailComponent = ({
  name,
  date,
  type,
  text,
  image,
  audio,
  id,
  
}) => {
  const imgSrc = image === 'img1' ? img1 : image === 'img2' ? img2 : img3;
  return (
    <div>
      <div className="media">
        <img
          className="align-self-start mr-3"
          src={imgSrc}
          alt={name}
          style={{
            height: '25rem',
          }}
        />
        <div className="media-body mt-3">
          <h5 className="mt-0">Name: {name}</h5>
          <p>Text: {text}</p>
          <p>Type: {type}</p>
          <p>Date: {date} </p>
          <p>Audio: {audio} </p>
        </div>
      </div>
      <div className="row ml-5 mt-3">
        <Link to={'/'} className="btn btn-outline-dark">
          Go back
        </Link>
      </div>
    </div>
  );
};

export default ItemDetailComponent;
