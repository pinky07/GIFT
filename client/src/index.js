import React from 'react'
import { render } from 'react-dom';
import { Provider } from 'react-redux';
import { Router, Route, hashHistory } from 'react-router'
import Main from './components/main';
import configStore from './store/configStore';
require('../node_modules/grommet/grommet.min.css');
require('./css/app.css');

const store = configStore();

render((
  <Provider store={store}>
    <Router history={hashHistory}>
      <Route path="/" component={Main}/>
    </Router>
  </Provider>
), document.getElementById('app'))