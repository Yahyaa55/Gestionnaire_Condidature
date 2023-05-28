import logo from './logo.svg';
import './App.css';

function App() {
  return (
    /*<div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>*/
    <div class="card">
  <div class="header">
    <div>
      <a class="title" href="#">
        Stagiaire Devloppement Web
      </a>
      <p class="name">By Emsi</p>
    </div>
      <span class="image"></span>
  </div>
    <p class="description">
      Lorem ipsum dolor sit, amet consectetur adipisicing elit. At velit illum
      provident a, ipsa maiores deleniti consectetur nobis et eaque.
    </p>
  <dl class="post-info">
    <div class="cr">
      <dt class="dt">Published</dt>
      <dd class="dd">31st June, 2021</dd>
    </div>
    <div class="cr">
      <dt class="dt">Reading time</dt>
      <dd class="dd">3 minute</dd>
    </div>
  </dl>
</div>
  );
}

export default App;
