function App() {
  const profiles = [{ name: "Alice", age: 16 }, { name: "Bob", age: 31 }, {}];

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
      {profiles.map((profile, index) => {
        return <User name={profile.name} age={profile.age} key={index} />;
      })}
    </div>
  );
}

const User = function User(props) {
  return (
    <div>
      <h2>
        Hi! I am {props.name}, and {props.age} years old.
      </h2>
    </div>
  );
};

User.defaultProps = {
  name: "NoName",
  age: 0,
};

export default App;
