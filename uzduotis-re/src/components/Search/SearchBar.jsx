import React from 'react';

const SearchBar = ({ onChange }) => {
  return (
    <form>
      <input
        placeholder="Search product"
        onChange={onChange}
        type="text"
        className="form-control"
      />
    </form>
  );
};

export default SearchBar;
