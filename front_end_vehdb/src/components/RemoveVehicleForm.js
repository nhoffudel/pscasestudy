import React, { Component } from 'react';
import axios from 'axios';
import style from './Menu.css';

const RemoveVehicleForm = (props) => {
  const deleteVehicle = (event) => {
    event.preventDefault();
    axios.post("http://localhost:8080/vehicle-controller/delete", {
        VIN: event.target.VIN.value,
    }).then( props.history.push("/") )
}
      return (
        <div>
          <p></p>
          <form onSubmit={deleteVehicle}>
            <div className="form-group">
              <label htmlFor="VIN">VIN of vehicle to be deleted.</label><br/>
              <input className="form-control" type="text" required name="VIN"></input>
            </div><br/>
            <button type="submit" className={style.MenuButton1}>Delete vehicle</button>
          </form>
        </div>
      );
}
export default RemoveVehicleForm;