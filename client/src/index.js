import React from 'react'
import { render } from 'react-dom';
import Main from './components/main';
import { Router, Route, hashHistory } from 'react-router'
require('../node_modules/grommet/grommet.min.css');

render((
  <Router history={hashHistory}>
    <Route path="/" component={Main}/>
  </Router>
), document.getElementById('app'))