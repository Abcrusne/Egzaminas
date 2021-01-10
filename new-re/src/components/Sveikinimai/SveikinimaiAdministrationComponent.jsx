import React from 'react';
//import { Link } from 'react-router-dom';

function SveikinimaiAdministrationComponent({ greeting}) {
    return (
        <tr>
            <th scope="row">{greeting.id}</th>
            <td>
        <img
          // src={imgSrc}
          src={greeting.image}
          className="card-img-top"
          style={{ width: 50, height: 50 }}
          alt={greeting.name}
        />
      </td>
            <td>{greeting.name}</td>
           
        </tr>
    );
}

export default SveikinimaiAdministrationComponent;