import React, { Component } from 'react';
import axios from 'axios';
import style from './Menu.css';

const RemoveRecordForm = (props) => {
  const removeRecord = (event) => {
    event.preventDefault();
    axios.post("http://localhost:8080/record-controller/delete", {
        ID: event.target.ID.value,
    }).then( props.history.push("/") )
}
      return (
        <div>
          <p></p>
          <form onSubmit={removeRecord}>
            <div className="form-group">
              <label htmlFor="ID">ID of record to be deleted.</label><br/>
              <input className="form-control" type="number" required name="ID"></input>
            </div><br/>
            <button type="submit" className={style.MenuButton1}>Delete record</button>
          </form>
        </div>
      );
}
export default RemoveRecordForm;