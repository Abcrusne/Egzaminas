import React, { useContext, useEffect, useState } from 'react';
import axios from 'axios';
import myUrl from '../../AppConfig';
import GreetingDetailsComponent from './GreetingDetailComponent';
import ServicesContext from '../../context/ServicesContext';

const GreetingDetailContainer = (props) => {
  const { userCartService } = useContext(ServicesContext);
  const [currentUser, setCurrentUser] = useState(
    userCartService.getCurrentUser()
  );
  const [greeting, setGreeting] = useState(null);

  userCartService.updateCurrentUser = () =>
    setCurrentUser(userCartService.getCurrentUser());

  useEffect(() => {
    axios
      .get(`${myUrl}/api/greetings/${props.match.params.id}`)
      .then((res) => setGreeting(res.data))
      .catch((err) => console.log(err));
  }, [props.match.params.id]);

  // const addToCart = () => {
  //   axios
  //     .post(`${myUrl}/api/users/${currentUser}/cart-greetings`, {
  //       id: Greeting.id,
  //       image: Greeting.image,
  //       title: Greeting.title,
  //       description: Greeting.description,
  //       price: Greeting.price,
  //       quantity: Greeting.quantity,
  //     })
  //     .then(() => {
  //       axios
  //         .get(`${myUrl}/api/users/${currentUser}/cart-greetings`)
  //         .then((res) => {
  //           userCartService.setCartCount(res.data.length);
  //           userCartService.updateCartCount();
  //         });
  //     })
  //     .catch((err) => console.log(err));
  // };

  if (greeting !== null) {
    const { id, image, title, ...otherProps } = greeting;
    console.log(id);
    return (
      <div className="container">
        <div key={id}>
          <GreetingDetailsComponent
            id={id}
            currentUser={currentUser}
            userCartService={userCartService}
            image={image}
            //addToCart={addToCart}
            title={title}
            {...otherProps}
          />
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
};

export default GreetingDetailContainer;
