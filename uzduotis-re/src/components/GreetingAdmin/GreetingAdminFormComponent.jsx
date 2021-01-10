import React from 'react';

const GreetingAdminFormComponent = ({
  handleChange,
  handleSubmit,
  ...otherProps
}) => {
  const { audio, image, name, text, date, type } = otherProps;
  return (
    <div>
      <form className="container my-5" onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="productTitle">Audio</label>
          <input
            onChange={handleChange}
            type="text"
            className="form-control"
            id="productTitle"
            name="title"
            value={audio}
          />
        </div>
        <div className="form-group">
          <label htmlFor="productImage">Image</label>
          <input
            onChange={handleChange}
            type="text"
            className="form-control"
            id="productImage"
            name="image"
            value={image}
          />
        </div>
        <div className="form-group">
          <label htmlFor="productDescription">Text</label>
          <textarea
            onChange={handleChange}
            className="form-control"
            id="productDescription"
            rows="3"
            name="description"
            value={text}
          ></textarea>
        </div>
        <div className="row">
          <div className="form-group col-6">
            <label htmlFor="productPrice"> Name</label>
            <input
              onChange={handleChange}
              type="text"
              className="form-control"
              id="productPrice"
              name="price"
              value={name}
            />
          </div>
          <div className="form-group col-6">
            <label htmlFor="productQuantity">Date</label>
            <input
              onChange={handleChange}
              type="date"
              className="form-control"
              id="productQuantity"
              name="quantity"
              value={date}
            />
          </div>
          <div className="form-group col-6">
            <label htmlFor="productQuantity">Select type</label>
            <select>
              <option value={type}>TV</option>
              <option value={type}>ONLINE</option>
              <option value={type}>REAL</option>
            </select>
          </div>
        </div>
        <button type="submit" className="btn btn-primary">
          Save
        </button>
      </form>
    </div>
  );
};
export default GreetingAdminFormComponent;
