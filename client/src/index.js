import React from 'react'
import { render } from 'react-dom';
import { Provider } from 'react-redux';
import { Router, Route, hashHistory, IndexRoute } from 'react-router'
import Main from './components/main';
import configStore from './store/configStore';
import './css/main.scss';

import ProjectList from './components/projectList/ProjectList';
import Portfolios from './components/portfolios/Portfolios';
import Dashboard from './components/dashboard/Dashboard';
import NotFound from './components/notFound/NotFound';

const store = configStore();

render((
  <Provider store={store}>
    <Router history={hashHistory}>
      <Route path={"/"} component={Main}>
        <IndexRoute component={Portfolios}></IndexRoute>
        <Route path={"projects/:id"} component={ProjectList}></Route>
        <Route path={"projects/:id/dashboard"} component={Dashboard}></Route>
        <Route path={"portfolios"} component={Portfolios}></Route>
        <Route path="*" component={NotFound} />
      </Route>

    </Router>
  </Provider>
), document.getElementById('app'))