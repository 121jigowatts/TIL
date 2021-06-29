import axios from "axios";

axios.defaults.baseURL = process.env.REACT_APP_ENDPOINT;

const Product = () => {
  axios.get("/products").then((response) => {
    const products = response.data;
    console.log(products);
  });

  return <div>Products</div>;
};

export default Product;
