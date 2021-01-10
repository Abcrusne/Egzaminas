import React from 'react';
//import { Link } from 'react-router-dom';

function NaujasSveikinimasComponent({
  handleSubmit,
  handleChange,
  audio,
  image,
  name,
  text,
  date,
  type,
}) {
  return (
    <form onSubmit={(e) => handleSubmit(e)}>
      <div className="form-group">
        <label htmlFor="name">
          <b>Name</b>
        </label>
        <input
          name="name"
          type="text"
          className="form-control"
          value={name}
          onChange={(e) => handleChange(e)}
        />
      </div>
      <div className="form-group">
        <label htmlFor="text">
          <b>Text</b>
        </label>
        <input
          name="text"
          type="text"
          className="form-control"
          value={text}
          onChange={(e) => handleChange(e)}
        />
      </div>
      <div className="form-group">
        <label htmlFor="image">
          <b>Image</b>
        </label>
        <input
          name="image"
          type="text"
          className="form-control"
          value={image}
          onChange={(e) => handleChange(e)}
        />
      </div>
      <div className="form-group">
        <label htmlFor="audio">
          <b>Audio</b>
        </label>
        <input
          name="audio"
          type="text"
          className="form-control"
          value={audio}
          onChange={(e) => handleChange(e)}
        />
      </div>
      <div className="form-group">
        <label htmlFor="date">
          <b>Date</b>
        </label>
        <input
          name="date"
          type="text"
          className="form-control"
          value={date}
          onChange={(e) => handleChange(e)}
        />
      </div>
      {/* <div className="form-group">
                <label htmlFor="laikas"><b>Laikas</b></label>
                <input name="laikas" type="text" className="form-control" value={laikas} onChange={(e) => handleChange(e)} />
            </div> */}
      <div className="form-group">
        <label htmlFor="type">
          <b>Type</b>
        </label>
        <select
          value={type}
          className="form-control"
          name="type"
          id="type"
          onChange={(e) => handleChange(e)}
        >
          <option value=""></option>
          <option value="tv">TV</option>
          <option value="online">ONLINE</option>
          <option value="real">REAL</option>
        </select>
      </div>
      <button type="submit" className="btn btn-primary">
        Submit
      </button>
    </form>
  );
}

export default NaujasSveikinimasComponent;
