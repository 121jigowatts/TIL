import React, { useState, useEffect } from "react";

function Tick() {
  const [date, setDate] = useState(new Date());

  useEffect(() => {
    const interval = setInterval(() => {
      setDate(new Date());
    }, 1000);
    return () => clearInterval(interval);
  });

  return (
    <div>
      <h2>{date.toLocaleTimeString()}</h2>
    </div>
  );
}

export default Tick;
