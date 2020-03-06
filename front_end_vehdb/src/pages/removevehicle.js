import React from 'react';
import ReactDOM from 'react-dom';
import HeaderMenu from 'components/HeaderMenu';
import RemoveVehicleForm from 'components/RemoveVehicleForm';

ReactDOM.render(<HeaderMenu />, document.getElementById('HeaderMenu'));
ReactDOM.render(<RemoveVehicleForm />, document.getElementById('RemoveVehicleForm'));