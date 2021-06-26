function App() {
  return (
    <div>
      <h1>Hello, World!</h1>
      <button
        onClick={() => {
          console.log("push!");
        }}
      >
        PUSH!
      </button>
      <User name={"Alice"} age={16} />
    </div>
  );
}

const User = function User(props) {
  return (
    <div>
      <h2>Hi! I am {props.name}, and {props.age} years old.</h2>
    </div>
  );
};

export default App;
