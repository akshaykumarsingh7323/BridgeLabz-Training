package com.binarysearchtree.ecommerceproductinventry;

public class ProductBST {
    private ProductNode root;

    public void insert(Product product) {
        root = insertRec(root, product);
    }

    private ProductNode insertRec(ProductNode root, Product product) {
        if (root == null) {
            return new ProductNode(product);
        }

        if (product.getSku() < root.product.getSku()) {
            root.left = insertRec(root.left, product);
        } else if (product.getSku() > root.product.getSku()) {
            root.right = insertRec(root.right, product);
        }
        return root;
    }

    public Product search(int sku) {
        return searchRec(root, sku);
    }

    private Product searchRec(ProductNode root, int sku) {
        if (root == null) return null;

        if (sku == root.product.getSku()) {
            return root.product;
        }

        if (sku < root.product.getSku()) {
            return searchRec(root.left, sku);
        }
        return searchRec(root.right, sku);
    }

    public boolean updatePrice(int sku, double newPrice) {
        Product product = search(sku);
        if (product != null) {
            product.setPrice(newPrice);
            return true;
        }
        return false;
    }

    public void displaySorted() {
        System.out.println("Products (Sorted by SKU):");
        inorder(root);
    }

    private void inorder(ProductNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println("SKU: " + root.product.getSku() +
                    ", Name: " + root.product.getName() +
                    ", Price: ₹" + root.product.getPrice());
            inorder(root.right);
        }
    }
}
