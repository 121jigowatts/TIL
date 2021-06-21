const express = require("express");
const app = express();
const port = 3000;

app.use(express.json());

let products = [];

app.get("/", (req, res) => res.send("Hello World!"));

app
  .route("/products")
  .get((req, res) => {
    res.json(products);
  })
  .post((req, res) => {
    // スプレッド構文 (...): 配列やオブジェクトを展開することができるÏ
    const newProduct = { ...req.body, id: products.length + 1 };
    products = [...products, newProduct];
    res.json(newProduct);
  })
  .put((req, res) => {
    let updatedProduct;
    products = products.map((p) => {
      if (p.id === req.body.id) {
        // オブジェクトのマージ
        updatedProduct = { ...p, ...req.body };
        return updatedProduct;
      }
      return p;
    });
    res.json(updatedProduct);
  })
  .delete((req, res) => {
    // 単項演算子(plus): 数値でないオペランドの数値への変換を試みる
    const deletedProduct = products.find((p) => p.id === +req.body.id);
    products = products.filter((p) => p.id !== +req.body.id);
    res.json(deletedProduct);
  });

app.listen(port, () => console.log(`Example app listening on prot ${port}!`));
