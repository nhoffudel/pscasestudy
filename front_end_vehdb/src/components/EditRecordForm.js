import React, { Component } from 'react';
import axios from 'axios';
import style from './Menu.css';

const EditRecordForm = (props) => {
  const editRecord = (event) => {
    event.preventDefault();
    axios.post("http://localhost:8080/record-controller/edit", {
        ID: 1,
        vehicleVIN: event.target.vehicleVIN.value,
        name: event.target.name.value,
        date: event.target.date.value,
        miles: event.target.miles.value,
        cost: event.target.cost.value,
        location: event.target.location.value,
        owner: 1,
        notes: event.target.notes.value
    }).then( props.history.push("/") )
}
      return (
        <div>
          <p></p>
          <form onSubmit={editRecord}>
            <div className="form-group">
              <label htmlFor="ID">ID of record to be edited</label><br/>
              <input className="form-control" type="number" required name="ID"></input>
            </div>
            <div className="form-group">
              <label htmlFor="vehicleVIN">VIN</label><br/>
              <input className="form-control" type="text" required name="vehicleVIN"></input>
            </div>
            <div className="form-group">
              <label htmlFor="name">Name of service</label><br/>
              <input className="form-control" type="text" required name="name"></input>
            </div>
            <div className="form-group">
              <label htmlFor="date">Date in MMDDYY</label><br/>
              <input className="form-control" type="number" required name="date"></input>
            </div>
            <div className="form-group">
              <label htmlFor="miles">Miles</label><br/>
              <input className="form-control" type="number" required name="miles"></input>
            </div>
            <div className="form-group">
              <label htmlFor="cost">Cost</label><br/>
              <input className="form-control" type="number" required name="cost"></input>
            </div>
            <div className="form-group">
              <label htmlFor="location">Location</label><br/>
              <input className="form-control" type="text" required name="location"></input>
            </div>
            <div className="form-group">
              <label htmlFor="notes">Notes</label><br/>
              <input className="form-control" type="text" required name="notes"></input>
            </div><br/>
            <button type="submit" className={style.MenuButton3}>Edit record</button>
          </form>
        </div>
      );
}
export default EditRecordForm;