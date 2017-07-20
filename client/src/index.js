import React from 'react'
import { render } from 'react-dom';
import { Provider } from 'react-redux';
import { Router, Route, hashHistory, IndexRoute } from 'react-router'
import Main from './components/main';
import configStore from './store/configStore';
import './css/main.scss';

import ProjectList from './components/projectList/ProjectList';
import Home from './components/home/Home';

const store = configStore();

render((
  <Provider store={store}>
    <Router history={hashHistory}>
      <Route path={"/"} component={Main}>
        <IndexRoute component={Home}></IndexRoute>
        <Route path={"projects"} component={ProjectList}></Route>
        <Route path={"home"} component={Home}></Route>
      </Route>

    </Router>
  </Provider>
), document.getElementById('app'))