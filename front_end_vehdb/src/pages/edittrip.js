import React from 'react';
import ReactDOM from 'react-dom';
import HeaderMenu from 'components/HeaderMenu';
import EditTripForm from 'components/EditTripForm';

ReactDOM.render(<HeaderMenu />, document.getElementById('HeaderMenu'));
ReactDOM.render(<EditTripForm />, document.getElementById('EditTripForm'));