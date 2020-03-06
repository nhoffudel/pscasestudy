import React from 'react';
import ReactDOM from 'react-dom';
import HeaderMenu from 'components/HeaderMenu';
import HomePageMenu from 'components/HomePageMenu';

ReactDOM.render(<HeaderMenu />, document.getElementById('HeaderMenu'));
ReactDOM.render(<HomePageMenu />, document.getElementById('HomePageMenu'));