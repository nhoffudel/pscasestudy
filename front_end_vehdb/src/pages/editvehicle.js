import React from 'react';
import ReactDOM from 'react-dom';
import HeaderMenu from 'components/HeaderMenu';
import EditVehicleForm from 'components/EditVehicleForm';

ReactDOM.render(<HeaderMenu />, document.getElementById('HeaderMenu'));
ReactDOM.render(<EditVehicleForm />, document.getElementById('EditVehicleForm'));