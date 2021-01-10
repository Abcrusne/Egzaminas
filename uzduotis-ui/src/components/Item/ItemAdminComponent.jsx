import React from 'react';
import { Link } from 'react-router-dom';
import img1 from '../../img/img1.png';
import img2 from '../../img/img2.jpg';
import img3 from '../../img/img3.jpg';
import Modal from '../modal/ModalComponent';

const ItemAdminComponent = ({ id, name, image, deleteItem }) => (
  //return greetings.map(({ id, image, name }) => {

  //const imgSrc = image === 'img1' ? img1 : image === 'img2' ? img2 : img3;

  <tbody>
    <tr key={id}>
      {/* key={id} */}
      <th scope="row">{id}</th>
      <td>
        <img
          // src={imgSrc}
          src={image}
          className="card-img-top"
          style={{ width: 50, height: 50 }}
          alt={name}
        />
      </td>
      <td>
        <Link to={`/admin/greetings/${id}`}>{name} </Link>
      </td>
      <td>
        <button className="btn btn-danger" onClick={deleteItem(id)}>
          Delete item
        </button>
      </td>
      {/* <td>
            <Modal 
            id={id}
            deleteItem={deleteItem}/>
          </td> */}
    </tr>
  </tbody>
);
// }
//   );
// };
export default ItemAdminComponent;
