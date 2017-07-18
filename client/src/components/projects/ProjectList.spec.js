/* eslint-env jest */
import React from 'react';
import { shallow } from 'enzyme';
import ProjectList from './ProjectList';

describe('Projects component', () => {
  it('Projects renders a list of projects', () => {
    const projectList = shallow(<ProjectList />);
    expect(projectList.find('li').length()).toBe(0);
  });
});