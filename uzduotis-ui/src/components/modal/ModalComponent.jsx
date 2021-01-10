import React from 'react';

const Modal = ({ id, deleteItem }) => {
  return (
    <div
      className="modal fade"
      id={`staticBackdrop${id}`}
      data-backdrop="static"
      data-keyboard="false"
      tabIndex="-1"
      aria-labelledby="staticBackdropLabel"
      aria-hidden="true"
    >
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-body">
            <button
              type="button"
              className="close"
              data-dismiss="modal"
              aria-label="Close"
            >
              <span aria-hidden="true">&times;</span>
            </button>
            Are you sure you want delete this item?
          </div>
          <div className="modal-footer">
            <button
              onClick={deleteItem}
              type="button"
              data-dismiss="modal"
              className="btn btn-danger"
              value={id}
            >
              Yes
            </button>
            <button
              type="button"
              className="btn btn-secondary"
              data-dismiss="modal"
            >
              Cancel
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};
export default Modal;
