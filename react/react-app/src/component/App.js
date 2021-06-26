import Counter from "./Counter";
import User from "./User";

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
      <Counter />
    </div>
  );
}

export default App;
