import React from 'react';

const FormComponent = ({ handleChange, handleSubmit, ...otherProps }) => {
  const { audio, image, name, text, date, type } = otherProps;
  return (
    <form className="container my-5" onSubmit={handleSubmit}>
      <div className="form-group">
        <label htmlFor="name"> Name</label>
        <input
          onChange={handleChange}
          type="text"
          className="form-control"
          id="name"
          name="name"
          value={name}
          required
        />
      </div>
      <div className="form-group">
        {/* <label htmlFor="itemImage">Image</label>
        <input
          onChange={handleChange}
          type="text"
          className="form-control"
          id="image"
          name="image"
          value={image}
        /> */}
        <label htmlFor="image">Select image</label>
        <select
          value={image}
          className="form-control"
          name="image"
          id="image"
          onChange={handleChange}
        >
          <option value="img1">img1</option>
          <option value="img2">img2</option>
          <option value="img3">img3</option>
        </select>
      </div>
      <div className="form-group">
        {/* <label htmlFor="description">Text</label>
        <input
          onChange={handleChange}
          type="text"
          className="form-control"
          id="description"
          rows="3"
          name="description"
          value={text}
        ></input> */}
        <label htmlFor="text">Text</label>
        <input
          onChange={handleChange}
          type="text"
          className="form-control"
          id="text"
          name="text"
          value={text}
          required
        />
      </div>
      <div className="row">
        <div className="form-group col-6">
          <label htmlFor="audio"> Audio</label>
          <input
            onChange={handleChange}
            type="text"
            className="form-control"
            id="audio"
            name="audio"
            value={audio}
          />
        </div>
        <div className="form-group col-6">
          <label htmlFor="date">Date</label>
          <input
            onChange={handleChange}
            type="text"
            className="form-control"
            id="date"
            name="date"
            value={date}
          />
        </div>
        <div className="form-group col-6">
          <label htmlFor="type">Select type</label>
          <select
            value={type}
            className="form-control"
            name="type"
            id="type"
            onChange={handleChange}
          >
            <option value="tv">TV</option>
            <option value="online">ONLINE</option>
            <option value="real">REAL</option>
          </select>
        </div>
      </div>
      <button type="submit" className="btn btn-primary btn-lg btn-block ">
        Save
      </button>
    </form>
  );
};
export default FormComponent;
