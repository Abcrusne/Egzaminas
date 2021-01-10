import React, { useEffect, useState } from 'react';
import axios from 'axios';
import myUrl from '../../AppConfig';
import ItemDetailComponent from './ItemDetailComponent';

const ItemDetailContainer = (props) => {
  const [greeting, setGreeting] = useState(null);

  // componentDidMount() {
  //   console.log(this.props.match.params.id);
  //   axios
  //     .get(`${myUrl}/api/greetings/${this.props.match.params.id}`)
  //     .then((res) => {
  //       this.setState({ greeting: res.data });
  //       console.log(res.data);
  //     })
  //     .catch((err) => {
  //       console.log(err);
  //     });
  // }
  useEffect(() => {
    axios
      .get(`${myUrl}/api/greetings/${props.match.params.id}`)
      .then((res) => setGreeting(res.data))
      .catch((err) => console.log(err));
  }, [props.match.params.id]);

  if (greeting !== null) {
    const {
      id,
      name,
      image,
      text,
      date,
      type,
      audio,
      ...otherProps
    } = greeting;
    return (
      <div className="container">
        <div key={id}>
          <ItemDetailComponent
            id={id}
            image={image}
            date={date}
            type={type}
            audio={audio}
            name={name}
            text={text}
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

export default ItemDetailContainer;
