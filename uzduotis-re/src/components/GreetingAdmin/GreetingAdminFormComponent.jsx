import React from 'react';

const GreetingAdminFormComponent = ({
  handleChange,
  handleSubmit,
  ...otherProps
}) => {
  const { title, image, firstname, text, lastname } = otherProps;
  return (
    <div>
      <form className="container my-5" onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="productTitle">Title</label>
          <input
            onChange={handleChange}
            type="text"
            className="form-control"
            id="productTitle"
            name="title"
            value={title}
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
            <label htmlFor="productPrice">First Name</label>
            <input
              onChange={handleChange}
              type="text"
              className="form-control"
              id="productPrice"
              name="price"
              value={firstname}
            />
          </div>
          <div className="form-group col-6">
            <label htmlFor="productQuantity">Last Name</label>
            <input
              onChange={handleChange}
              type="text"
              className="form-control"
              id="productQuantity"
              name="quantity"
              value={lastname}
            />
          </div>
          <div className="form-group col-6">
            <label htmlFor="productQuantity">Select type</label>
            <select>
              <option value="grapefruit">TV</option>
              <option value="lime">NET</option>

              <option value="mango">REAL</option>
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
