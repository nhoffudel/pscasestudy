import React, { Component } from 'react';
import axios from 'axios';
import style from './Menu.css';

const RemoveTripForm = (props) => {
  const removeTrip = (event) => {
    event.preventDefault();
    axios.post("http://localhost:8080/trip-controller/delete", {
        tripID: event.target.tripID.value,
    }).then( props.history.push("/") )
}
      return (
        <div>
          <p></p>
          <form onSubmit={removeTrip}>
            <div className="form-group">
              <label htmlFor="tripID">ID of trip to be deleted</label><br/>
              <input className="form-control" type="number" required name="tripID"></input>
            </div><br/>
            <button type="submit" className={style.MenuButton1}>Delete trip</button>
          </form>
        </div>
      );
}
export default RemoveTripForm;