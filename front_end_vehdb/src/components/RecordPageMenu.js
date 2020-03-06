import React, { Component } from 'react';
import {Link, BrowserRouter} from 'react-router-dom';
import style from './Menu.css';

export default class RecordPageMenu extends Component {
  render() {
    return (
      <BrowserRouter>
      <form action="/addrecord.html">
         <button type="submit" className={style.MenuButton2}>Add a service record</button>
      </form>
      <p></p>
      <form action="/editrecord.html">
         <button type="submit" className={style.MenuButton3}>Edit record</button>
      </form>
      <p></p>
      <form action="/removerecord.html">
         <button type="submit" className={style.MenuButton1}>Delete record</button>
      </form>
      </BrowserRouter>
    );
  }
}
