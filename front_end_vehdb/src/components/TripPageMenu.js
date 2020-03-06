import React, { Component } from 'react';
import {Link, BrowserRouter} from 'react-router-dom';
import style from './Menu.css';

export default class TripPageMenu extends Component {
  render() {
    return (
      <BrowserRouter>
      <form action="/addtrip.html">
         <button type="submit" className={style.MenuButton2}>Add a trip</button>
      </form>
      <p></p>
      <form action="/edittrip.html">
         <button type="submit" className={style.MenuButton3}>Edit trip</button>
      </form>
      <p></p>
      <form action="/removetrip.html">
         <button type="submit" className={style.MenuButton1}>Delete trip</button>
      </form>
      </BrowserRouter>
    );
  }
}
