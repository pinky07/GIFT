/* eslint-env jest */
import React from 'react';
import { shallow, mount } from 'enzyme';
import {ProjectList} from './ProjectList';

describe('ProjectList component', () => {
  it('ProjectList renders a list of projects', () => {
    const wrapper = mount(<ProjectList/>);
    expect(projectList.find('li').length()).toBe(0);
  });
});