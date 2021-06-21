const express = require("express");
const app = express();
const port = 3000;

app.use(express.json());

let products = [];

app.get("/", (req, res) => res.send("Hello World!"));

app
  .route("/products")
  .get((req, res) => {
    const page = +req.query.page;
    const pageSize = +req.query.pageSize;

    if (page && pageSize) {
      const start = (page - 1) * pageSize;
      const end = start + pageSize;
      res.json(products.slice(start, end));
    } else {
      res.json(products);
    }
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

app.get("/products/:id", (req, res) => {
  res.json(products.find((p) => p.id === +req.params.id));
});

app.listen(port, () => console.log(`Example app listening on port ${port}!`));
