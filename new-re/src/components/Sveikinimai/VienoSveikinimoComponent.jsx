import React from 'react';
import { Link } from 'react-router-dom';
import img1 from '../../img/img1.png';
import img2 from '../../img/img2.jpg';
import img3 from '../../img/img3.jpg';
function VienoSveikinimoComponent({ greeting }) {

    const imgSrc = greeting.image === 'img1' ? img1 : greeting.image === 'img2' ? img2 : img3;
  return (
    <div className="col">
        <div className="media">
     <img
          className="align-self-start mr-3"
          src={imgSrc}
          alt={greeting.name}
          style={{
            height: '25rem',
          }}
        />
      <h2>Name: {greeting.name}</h2>
      <p>Text: {greeting.text}</p>
      <p>Date: {greeting.date}</p>
      <p>Audio: {greeting.audio}</p>

      <p>Type: {greeting.type}</p>
    </div>
    <div className="row ml-5 mt-3">
        <Link to={'/'} className="btn btn-outline-dark">
          Go back
        </Link>
      </div>
    </div>
    
  );
}

export default VienoSveikinimoComponent;
