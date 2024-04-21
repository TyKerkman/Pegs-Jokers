import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom'
import Game from './pages/Game';

it('renders app', () => {
  render(<Game />);
  const linkElement = screen.getByText('Hypothetical Players Turn or Other Info Btw the button don\'t work');
  expect(linkElement).toBeInTheDocument();
});
