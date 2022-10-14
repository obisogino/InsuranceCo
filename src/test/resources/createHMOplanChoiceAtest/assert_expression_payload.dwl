%dw 2.0
import * from dw::test::Asserts
---
payload must equalTo({
  "status": 200,
  "message": "Covid and Dengue protection policy created"
})