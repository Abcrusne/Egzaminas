import React from 'react';

const SearchBar = ({ value, onChange }) => {
  return (
    <form>
      <input
        placeholder="Search by name "
        type="text"
        className="form-control my-3"
        onChange={onChange}
        value={value}
      />
    </form>
  );
};

export default SearchBar;
