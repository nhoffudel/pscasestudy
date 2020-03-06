import React, { Component } from 'react';
import axios from 'axios';
import style from './Menu.css';

const EditVehicleForm = (props) => {
  const editVehicle = (event) => {
    event.preventDefault();
    axios.post("http://localhost:8080/vehicle-controller/edit", {
        VIN: event.target.VIN.value,
        year: event.target.year.value,
        make: event.target.make.value,
        model: event.target.model.value,
        trim: event.target.trim.value,
        engine: event.target.engine.value,
        color: event.target.color.value,
        username: 1,
        notes: event.target.notes.value
    }).then( props.history.push("/") )
}
      return (
        <div>
          <p></p>
          <form onSubmit={editVehicle}>
            <div className="form-group">
              <label htmlFor="VIN">VIN</label><br/>
              <input className="form-control" type="text" required name="VIN"></input>
            </div>
            <div className="form-group">
              <label htmlFor="year">Year</label><br/>
              <input className="form-control" type="number" required name="year"></input>
            </div>
            <div className="form-group">
              <label htmlFor="make">Make</label><br/>
              <input className="form-control" type="text" required name="make"></input>
            </div>
            <div className="form-group">
              <label htmlFor="model">Model</label><br/>
              <input className="form-control" type="text" required name="model"></input>
            </div>
            <div className="form-group">
              <label htmlFor="trim">Trim</label><br/>
              <input className="form-control" type="text" required name="trim"></input>
            </div>
            <div className="form-group">
              <label htmlFor="engine">Engine</label><br/>
              <input className="form-control" type="text" required name="engine"></input>
            </div>
            <div className="form-group">
              <label htmlFor="color">Color</label><br/>
              <input className="form-control" type="text" required name="color"></input>
            </div>
            <div className="form-group">
              <label htmlFor="notes">Notes</label><br/>
              <input className="form-control" type="text" required name="notes"></input>
            </div><br/>
            <button type="submit" className={style.MenuButton3}>Edit vehicle</button>
          </form>
        </div>
      );
}
export default EditVehicleForm;