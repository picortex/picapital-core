# 0.02.65
## Added
- OnBoarding functionality
- Payment input field to create order form
- Fully paid checkbox field to create order form
- Order fulfilment actions on an order level
- A concept of sub actions

## Fixed
- Customer navigation issue
- Customer Edit and Duplicate forms stating "Editing/Duplicating 'nulls' info"

## Enhanced
- Customer screen reactions to invalid caches

## In Progress
- [ ] Retrieval of user information
  - [x] Abstract sign in response to return details of the user
  - [x] Implement the abstractions

## Scheduled
- Change Order Status    (API)
  - Change order status on a task item level
  - Change order status on a line item level
  - Refund Order           (API)
- Find a better name for PayRequest and move it into kost-sdk

# 0.02.59
## Fixed
- Create form on indenture scope being stack on Loading
- Customer form not adding a customer to a sale indenture while creating
- Switching to and from Table view

# 0.02.53
## Fixed
- Show products list while adding Orders
- Double navigation problem
- class 'NoDiscount' has to be '@Serializable', and the base class 'LineItemDiscount' has to be sealed and '@Serializable'. While creating a new order
- "Invoice not found" error when trying to edit/update/capture payment
- "Requisition not found" error when trying to edit/update/capture payment

## Removed
- Long console logs being logged when loading an order

## In Progress
- Retrieval of user information
  - Abstract sign in response to return details of the user
- Onboarding process
- Order fulfilment actions on an order level
  - A concept of sub actions

## Scheduled
- Change Order Status    (API)
  - Change order status on a task item level
  - Change order status on a line item level
- Refund Order           (API)
- Centralize cache invalidation
- A monad to observe live updates from the server for inter device settings configuration

# 0.02.45

## Fixed

- Capture payment error on submitting payment
- Wrong payment information on capture payment form
- Missing actions when you deep link to /invoice/{uid}, /orders/{uid}, /rfq/{uid}, /quotes/{uid}

## Added

- Full customer information to invoices, rfqs, quotations and orders
- Individual actions to sale indentures (No need for the hack that takes you through the selectors)

## Removed

- Customer reference from invoices, rfqs, quotations and orders in favor of full customer information

--------------------

# 0.02.26

## Libs

### Registra

#### Fixed

- SetPassword form not giving an enough window to show the erros

### Presenters

#### Added

- Selector.unSelect(item)

### Bitframe

#### Fixed

- CollectionScope.unselect to actually unselect an item from the selector

### Cellar

#### Fixed

- Order Dates are not being captured
- Discounts matching line item amount
- Order editing
- Order duplications

#### Added

- Fulfilment options on order level
    - OrderScope.markAs(TaskStatus) to mark different states of the order
    - OrdersScope.markAs(uid,TaskStatus)

#### Removed

- OrderAddViewModel
- OrderEditViewModel
- OrderDuplicateViewModel
- OrderFormViewModel

--------------------

# 0.02.16

## SDK

### Added

- FinaScope : which brings in many invoices scopes

### Fixed

- Order create and order duplicate not adding line items to the order view

## API

### Fixed

- Product LineItems details are being wrongly defaulted to just "Product"
- Service LineItems details are being wrongly defaulted to just "Service"

### Won't Fix

- Limit discounts to not exceed the selling price (SDK)
  Resolution: "Extra work for no reason @ all" ~ George

## Libs

### Kost

#### Added

- PaymentRequestFormScope: To help centralize forms for payments objects (i.e. Orders & Invoices)
- RemoteBuffer: To help buffer intentions before communication with the server

### Changed

- all LineItem & Discount Monetary objects to Money objects

### Fina

#### Added

- InvoicesScope : To enable us interact with the invoices table and list
- InvoiceScope : To enable us to fetch basic info of a single invoice
- InvoiceAddScope : To enable us to create a new invoice
- InvoiceEditScope : To enable us to edit a new invoice
- InvoiceDupScope : To enable us to duplicate a new invoice
- InvoiceFormScope : To centralize common invoice form operations

### Celar

### Added

- OrderFormScope : To enable us interact with order forms while reusing code from PaymentRequestFormScope
- OrderAddScope : To efficiently create new orders while reusing code from OrderFormScope
- OrderEditScope : To efficiently update orders while reusing code from OrderFormScope
- OrderDupScope : To efficiently duplicate orders while reusing code from OrderFormScope

### Deprecated

- OrderAddViewModel: In favour of OrderAddScope
- OrderEditViewModel: In favour of OrderEditScope
- OrderDuplicateViewModel : In favour of OrderDupScope

### Enhanced

- Order sumary to automatically be picked up on initializing the order form

### Kash

### Added

- `val Zero: Monetary`

### Changed

- Arithmetics rules on the money object: The library now doesn't zero based arithmetics on basic cases
- Constructor Monetary implementations: they now return the same `Zero` object on zero based allocations

### Removed

- `MonetaryValue` abstraction: Now we are just down to `Money`, and `Monetary: Money`

### Presenters

#### Changed

- `MoneyValueInputField<V:MonetaryValue>` to `MoneyValueInputField<Money>`

-----------------------------------------

# 0.02.09

## SDK

### Fixed

- Orders List & Orders table failing to load the second page

## Libs

### Authenticator

- Added BarrierScope to offer automatic authentication barrier throughout the App

### Kase

#### Added

- More casting constrains for all the current case types

### Kost

#### Added

- LineItems & LineItem discounts to account for granular and much more compound discount schemes

#### Changed

- cellar.LineItems to kost.LineItems

### Cellar

#### Added

- `setOrderDiscount` for the whole order
- orders.loadForCustomer(uid: String)
- Amount, Items & Discount columns in Orders Table

#### Fixed

- Orders returning line items with null input fields
- Item discounts not updating

### Presenters

#### Added

- Column.key to columns (so that we can have columns with empty names & index them by key instead of column names)
- Column.index to help the column manager sort these columns as desired
- ColumnManager.rename to rename the title of the columns easily
- ColumnManager.index to reindex columns

#### Fixed

- `ColumnManager.add` addition should just prioritize the consumers override

-----------------------

# 0.01.93

## Libs

### Stocker

#### Fixed

- Selling price not being sent while creating/updating form

#### Added

- `stocker.collections.Products` to reuse the Products table/list in ProductsViewModel and Cellar Product Select

#### Changed

- the type of `ProductFormParams.sellingPrice` from `Money` to `Monetary`

#### Removed

- stocker.LoadedProduct in favour of Product
- stocker.products.ProductRef in favour of kommerce.ProductRef
- stocker.products.SeviceRef in favour of kommerce.ServiceRef

### Flame

#### Added

- `flame.collections.Customers` to reuse the Customers table/list in CustomerViewModel and cellar customer select

### Cellar

#### Added

- `cellar.collections.LineItems`

#### Removed

- `cellar.orders.collections.ProductList` in favour of `stocker.collections.Products`
- `cellar.orders.collections.CustomerList` in favour of `flame.collections.Customers`

#### Changed

- `cellar.orders.collections.OrdersList` to `cellar.collections.Orders`

### Kommerce

A Library for centralizing offerable (service, products, custom) abstractions

#### Added

- Offerable
- ProductRef
- ServiceRef

### Kost

#### Fixed

- class Unique has not been registered for polymorphic serialization

### Presenters

#### Fixed

- `SelectionManager.unselectAllInCurrentPage` bug

#### Added

- `Page.hasMore` to know if a page of a collection has more items
- `Page.isLastPage` to know if it is a current page
- `Page.isFirstPage` to know if a page is a first page
- `PaginationManager.hasMore` to know if a paginator has more items to load

### Kash

### Fixed

- `centsAsLong` is readonly bug on Monetary

#### Added

- Monetary class for dealing with money like things without worrying about the underlying currency

### Actions

#### Added

- `Action.key` to aid the action manager to properly index & identify each action

------------------------------------- 

# 0.01.70

## API

### Added

- available quantity of stock managed (i.e. Physical) products
- Selling price on every product
- Inventory status of a stock managed product

## SDK

### Settings

#### Added

- Business Account settings
- Personal settings

## Libs

### Fina

A module for managing and tracking invoicing at large

### Stocker

#### Added

| Definitions            | Explanation                                                                                                                                                                    |
|:-----------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Inventory              | A top level sealed class to hold inventory information                                                                                                                         |
| UnknownInventory       | An object extending the Inventory class that represents a product whose inventory status is not know yet (can be managed/unmanaged but the user hasn't been specific about it) |
| UnmanagedInventory     | An object extending the Inventory class that represents a product whose inventory will not be managed (Non Physical product)                                                   |
| ManagedInventory       | A data class that holds information of currently active records a product has                                                                                                  |
| ManagedInventory.Batch | A class which holds information of different batches available for a particular product                                                                                        |

#### Deprecated

- LoadedProduct in favour of Product

#### Removed

- InventoryRecord in favour of ManagedInventory.Batch

### Cabinet

#### Removed

- FileBlob
- Blob
- ByteArrayBlob

## Dependencies

| Library/Framework     | Previous Version            | Current Version |
|:----------------------|:----------------------------|-----------------|
| kotlin                | 1.7.20                      | 1.8.0           |
| kotlin/react          | 0.0.1-pre.327-kotlin-1.6.20 | 1.0.0-pre.480   |
| npm-publish           | 3.0.3                       | 3.2.0           |
| okio                  | 3.2.0                       | 3.3.0           |
| ktor                  | 2.0.3                       | 2.2.2           |
| kotlinx/serialization | 1.3.3                       | 1.4.1           |
| kotlinx/coroutines    | 1.6.3                       | 1.6.4           |
| kotlinx/datetime      | 0.3.3                       | 0.4.0           |
|                       |                             |                 |

----------------------------

# 0.01.65

## SDK

### Added

- Product images uploading and deletion should Behave like attachments

## Libs

### Stocker

#### Added

- `ProductsImagesViewModel` to be able to upload and delete images
- StockerScope to minimize declarations in the overall SDK
- `ProductImagesViewModel` scope

### Presenters

#### Added

- `ColumnsManager` for tables to make it easy to add or remove columns on a table without too much hacks
- `ActionsManager` for tables & scrollable lists to make it easy to add or remove actions on a table without too much
  hacks

#### Changed

- Default SelectionManager to a newly rewritten SelectionManager
- Default PaginationManager to be a newly rewritten pagination manager
- `fun <D> columnsOf() : List<Columns<D>>` to `fun <D> columnsOf() : ColumnsManager<D>`
- `MultiFileInput.data.output : List<FileBlob>?` to `MultiFileInput.data.output : List<FileBlob>`
- `Setter<T>.set(value: T)` to `Setter<T>.set(value: T?)`

#### Removed

- `SelectorState`

-----------

# 0.01.60

## SDK

### Orders

#### Added

- Add order form
- Edit order form
- Duplicate order form

## Libs

### Bitframe

#### Added

- `fun CollectionsViewModel::initialize()` to have a uniform API for all collections
- `fun CollectionsViewModel::deInitialize()` to have a uniform API for all collections

### Stocker

#### Changed

- Price label from "price" to "selling price"

### Cellar

#### Added

- `Form.add(it: InventoryItem)` on Order form
- `Form.remove(li: LineItem)` on Order form
- `flame` and `stocker` sdks as a dependency so that we can select products and customers while creating an order

#### Moved

- `sdk/client` into `sdk/client/core` to match conventions

### Live

#### Added

- `useNullableLive` react hook : To watch a live that sometimes can be null

### Presenters

#### Added

- `DataCollection` and `DataCollectionImpl`
- `ListInputField`
- `tableOf()` method with a trailing lambda `ColumnsBuilder`
- `actionsOf()` method to have default empty actions
- `ActionManagerBuilder<T>.onAdd` method to ease building of actions
- `ActionManagerBuilder<T>.onAddAll` method to ease building of actions
- `ListInputField.update` method to be able to update fields already in the ListInputList

#### Removed

- `TableImpl` in favour of `DataCollectionImpl`
- `ScrollbleListImpl` in favour of `DataCollectionImpl`
- `PageableImpl`

-----------

# 0.01.46

# BREAKING CHANGE

### Stocker

#### Added

- Price input field
- Physical Product

### Presenters

#### Added

- `Validateable0`
- `Validateable1`
- `MoneyInputField`

#### Removed

- InputFieldWithValue
- MultiFileInputField

### Live

#### Added

- MultiLiveWatch featcher: To allow watching from different live objects

-----------

# 0.01.45

## SDK

### products

#### Added

- Image input field

## Libs

### Cabinet

#### Changed

- `fun RootDir.list() : kotlinx.collection.interopertable.List` to `fun RootDir.list() : kollections.List`

### Presenters

#### Added

- SingleFileInputField
- MultiFileInputField

### Koncurrent

#### Removed

- Functional interfaces for non jvm platform

-----------

# 0.01.37

## Libs

### Stocker

#### Added

- `ProductCategoryForm`
- `ProductCategoryField`

### Actions

#### Changed

- `SimpleAction` to `SimpleAction<O>`
- `MutableSimpleAction` to `MutableSimpleAction<O>`
- `GenericAction<I>` to `GenericAction<I,O>`
- `MutableGenericAction<I>` to `MutableGenericAction<I,O>`

### Kase

#### Added

- `FormState`

### Koncurrent

#### Removed

- `ConcurrentState<T>` in favour of `kase.ExecutorState<T>` and `kase.Result<T>`

### Presenters

#### Fixed

- Page 1 of Capacity 10 was not found in memory

#### Changed

- `Form<F,P>` to `Form<F,P,R>`
- `Form<F,P>.submit(): Later<Any?>` to `Form<F,P,R>.submit(): Later<R>`

#### Removed

- `FormState` in favour of `kase.FormState`

#### Deprecated

- `presenters.actions` in favour of `actions`
- `presetners.states` in favour of `kase`

### Krest

#### Added

- `Options.topic` for subscription purposes

-----------

# 0.01.32

## SDK

### Added

- `PiCortexWorkerFactor` to create `UploadCustomerAttachmentWorker` as a background worker for picortex application

## Libs

### Stoker

#### SDK

##### Added

- Product categories single select field
- Status in product columns
- SKU in products columns
- Product Edit functionality

### ViewModel

#### Added

- `LazyViewModel`: To simplify a repitative pattern for our viewmodels
- `ConfigImpl`: To centralize all our implementations

### Removed

- `core/src/commonMain/kotlin/viewmodel/internal/AbstractViewModelConfig.kt` in favour of ConfigImpl
- `core/src/commonMain/kotlin/viewmodel/internal/ScopeConfigImpl.kt` in favour of ConfigImpl
- `core/src/commonMain/kotlin/viewmodel/internal/StatefulViewModelConfigImpl.kt` in favour of ConfigImpl

### Presenters

#### Deperecated

- `presenters.states` package in favour of `kase`
- `presenters.actions` package in favour or `actions`

### Cabinet

#### Deprecated

- `cabinet.Blob` related code in favour of `epsilon.Blob`
- `cabinet.FileBlob` related code in favour of `epsilon.FileBlob`
- `cabinet.FakeBlob` related code in favour of `epsilon.FakeBlob`
- `cabinet.ByteArrayBlob` related code in favour of `epsilon.ByteArrayBlob`
- `cabinet.NetworkBlob` related code in favour of `epsilon.NetworkBlob`

### Epsilon

*New Library*
Created Epsilon: A Multiplatform lib that defines and use Blobs [FileBlobs, NetworkBlobs, AuthenticatedBlobs, e.t.c]

#### Added

- `FileBlob.path` : To easily schedule work from krest.WorkManage

### Krest

*New Library*
Created Krest: A Multiplatform Work scheduling library to handle long running backgroud work

#### Added

- ImmediateWorker: That schedules backgroud work to execute immediately
- VoidFactory: To use as a default factory for applications that don't even have the need to do backgroud work

### Kase

*New Library*
Since states [Loading|Success|Failure] can be used in a broader scope beyond presenters,
it makes sense to extract them in a self contained lib that will be imported in presenters and elsewhere

### Actions

*New Library*
Seperated actions from presenters as well. They are dependencies to Kase and thats what prompted the extraction.
Although we currently use them in presenters only, they are layer agnostic and can be use in different places

# 0.01.31

## SDK

### Added

- `OrderInfo` scope
- `OrderAdd` scope
- `OrderEdit` scope
- `OrderDuplicate` scope
- `OrderDelete` feature

### Fixed

- SingleSelectDropDown inputs crashing
- Edit/Duplicate input fields caching old values

## API

### Added

- Edit product scope

## Libs

### Cellar

#### SDK

##### Added

- `OrderFormViewModel`
- `OrderAddViewModel : OrderFormViewModel`
- `OrderEditViewModel : OrderEditViewModel`
- `OrderDuplicateViewModel : OrderEditViewModel`

### Stocker

#### SDK

##### Fixed

- Barcode input field to label appearing as name
- Add Product action having an Add Customer Label
- Category returning as a default

-----------

# 0.01.25

## Libs

### Stocker

#### SDK

##### Fixed

- Barcode input field to label appearing as name
- Add Product action having an Add Customer Label
- Category returning as a default

------------

# 0.01.24

## SDK

### Added

- Orders View (List & Table)
- Delete single order
- Delete bulk order
- Bulk Delete Customer Feature

## API

### Added

- Cellar Api
- Bulk Delete Customer Feature

## Libs

### Cellar

#### Api

##### Added

- OrdersApi

##### SDK

- `OrdersViewModel`

### Flame

#### SDK

##### Removed

- CustomersCacheKeys

### Stocker

#### SDK

##### Removed

- ProductsCacheKeys

------------

# 0.01.23

## Libs

### Presenters

#### Added

- `BooleanBasedInputField`
- `TextBasedInputField::hint` property

#### Changed

- `@JsExport open class TextBasedInputFieldImpl` to `class TextBasedInputField`
- `ValuedField<O>` to `ValuedField<O:Any>`
- `ValuedField<O>::output : Live<O>` to `ValuedField<O:Any>::output : Live<O?>`

#### Removed

- `TextInputField` in favour of `TextBasedInputField<String>`
- `PhoneInputField` in favour of `TextBasedInputField<String>`
- `EmailInputField` in favour of `TextBasedInputField<String>`
- `PasswordInputField` in favour of `TextBasedInputField<String>`
- `RadioInputField` in favour of `BooleanBasedInputField`
- `CheckboxInputField` in favour of `BooleanBasedInputField`
- `SwitchInputField` in favour of `BooleanBasedInputField`
- `LongInputField` in favour of `NumberBasedInputField<Long>`
- `IntInputField` in favour of `NumberBasedInputField<Int>`
- `DoubleInputField` in favour of `NumberBasedInputField<Double>`

### Krono

#### Added

- `LocalDate.toJsDate`

----------

# 0.01.21

# # # # # # # # # # # # # # # # # # # # #

#                                              #

### This is a breaking change         ###

#                                              #

# # # # # # # # # # # # # # # # # # # # #

## SDK

### Added

- `ProductAdd` scope
- `ProductEdit` scope
- `ProductDuplicate` scope

## Libs

### Kost

### Added

- Payment Method
- Payment Status
- Payment
- ItemizedCalculable

### Stocker

#### Added

- ProductAddViewModel to allow adding new products
- ProductEditViewModel to allow editing existing products
- ProductDuplicateViewModel to allow duplicating existing products

#### Changed

- `stocker.products.utils.intents.Intent` into `stocker.products.utils.Intent`
- `stocker.products.utils.intents.AddProductIntent` into `stocker.products.utils.AddProductIntent`
- `stocker.products.utils.intents.EditProductIntent` into `stocker.products.utils.EditProductIntent`
- `stocker.products.utils.intents.DuplicateProductIntent` into `stocker.products.utils.DuplicateProductIntent`

### Presenters

#### Added

- `TextMappedInputField<T>` to and make text based input fields that can be mapped into other objects
- `RangeValuedField<I,O>`
- `ChoiceField`
- `SingleChoiceValuedField<T>: ChoiceField, ValuedField<T>`
- `MultiChoiceVAluedField<T>: ChoiceField, ValuedField<T>`

#### Changed

- `InputField.value` to `InputField.setValue()`
- `@Throws fun validate()` to `fun validate() : ValidationResult`
- `validateWithFeedback` to `validateSettingInvalidsAsErrors` and `validateSettingInvalidsAsWarnings`
- `DateInputField` to implement `RangedValueField<String,O>`
- `DateRangeInputField` to contain a start and an end independent `DateInputField`
- `LocationInputField` to implement `ValuedField<GeoLocation>`

#### Removed

- `EmailInputField` in favour of `TextBasedInput<String>`
- `PhoneInputField` in favour of `TextBasedInput<String>`
- `PasswordInputField` in favour of `TextBasedInput<String>`

### Krono

#### Added

- `fun LocalDateOrNull(iso: String?) : LocalDate?`

----------

# 0.01.20

## SDK

### Added

- `Product.barcode`
- `Product.sku`
- `Product.requiresPermission`

## API

### Added

- Can now create/edit/load/delete product category

## Libs

### Stocker

#### Added

- `ProductCategoryApi`
- `LoadedProduct.photos`

### Registra

#### Changed

- Test sources location from `picorte-api-pione-rest` to `registra-pione`

### Flame

#### Changed

- Test sources location from `picorte-api-pione-rest` to `flame-pione`

### Authenticator

#### Changed

- Test sources location from `picorte-api-pione-rest` to `authenticator-pione`

### Presenters

#### Added

- `presenters-collection-renders-string` : for rendering Tables to strings
- `presenters-collection-renders-console` : for rendering Tables to consoles

#### Changed

- kash related presenters from `presenters-core` to `presenters-kash` subproject
- input related presenters (i.e. `prensenters.fields` & `presenters.form`) to `presenters-inputs` subproject
- collection related presenters to `presenters-collections-core`
- state related presenters to `presenters-states`
- `presenters-core` to `presenters-misc`

#### Removed

- `presenters-mock`

-----------

# 0.01.19

## API

### Fixed

- Sign in issue

## Libs

### Cellar

#### Introduction

Introduces a module to handle ordering at large

### Kost

#### Introduction

Abstractions for general payment requests that can be used in

- Ordering
- Invoicing
- Bills

### Krono

#### Added

- `ZonedDateTime`: to handle dates and times in a particular timezone
- `Instant` : to unify general serving of time
- `LocalDateTime` : to handle both dates and times in a local timezone
- Serializers for `LocalTime`, `LocalDateTime` and `Instant`

### PiOne

#### Removed

- `PiOneParser`: We are no longer manually parsing PiOne fields

### Flame

#### Removed

- `CustomerPiOneParser` : Following the removal of `PiOneParser`
- `CustomerPiOneApi.parser` : Follows the removal of `CustomerPiOneParser`

#### Changed

- `kotlinx-collections-interoperable.*` to `kollections.*`

-----------------------

# 0.01.18

## Libs

### Geo

#### Changed

- `val GeoLocation::lines: kollections.interoperable.List` to `val GeoLication::lines: kollections.List`

### Presenters

#### Added

- GoogleApiLocation Support

#### Changed

- `field.LocationInputField` to `fields.LocationInputField`

-----------

# 0.01.17

## SDK

### Added

- `SetPassword` form
- Auto login after user sets theirs password for the first time

### Fixed

- Search bug: No items found triggers whenever any page returns zero.
  e.g. if page no. 2 has zero items, the paginator says there are no items
  while it is clear that there were Items in page 1

## Libs

### Presenters

#### Fixed

- Paginator crash on rapid clicks

#### Added

- `ConfirmationDialog.cancel()`

#### Changed

- ValuedField to `ValuedField<T>`
- `RangeBasedField<T>: SingleValuedField<T>` to `RangeField<T>: ValuedField<T>`
- SelectMany to use `kollections.List` instead of `kotlin.collections.List`
- `ConfirmationDialog.ui` to `ConfirmationDialog.state`

#### Removed

- `SingleValuedField` in favour of `ValuedField<T>`
- `ConfirmationState` in favour of `LazyState<Unit>`
- `kotlinx.collections.interoperable` infavour of `kollections`

### Live

#### Fixed

- Live values with zero history capacity crash

----------

# 0.01.07

## SDK

### Added

- BarCode Support
- Address fields for customer form

### Changed

- Location fields from being `TextInputFields` into `LocationInputFields`

## Libs

### Flame

#### Added

- Address field to individual customer form

### Changed

- location field of individual customer form from `TextInputField` to `LocationInputField`
- location field of corporate customer form from `TextInputField` to `LocationInputField`

### Koder

#### Added

- `BarCode` interface abstraction
- `BarCodeUPC` interface abstraction
- `BarCodeUPC` implementation
- `BarCodeUPC` constructors
- `BarCodeUPCSpec` to easily access the UPC barcode Specification

----------

## 0.01.06

### SDK

#### Added

- SetPasswordViewModel

#### Fixed

- Products loading page by adding `isLinient=true` in our codex (This is not JSON spec compliant)

### API

#### Added

- `SignUpApiPiOneKtor` as an implementation to `SignUpApi`

#### Changed

- `SignUpApi.sendVerificationLink` signature to only accept email

### Libs

#### Authenticator

##### Added

- `AuthenticatorApi.createUserAcount`

#### Stocker

##### Removed

- `MockProduct` in favour of `LoadedProduct`

#### Live

##### Added

- Watchable interface to ease maintainability
- `LiveMap` and a `MutableLiveMap` to easily observe Map/Table like datasctructures

----------

## 0.10.04

### SDK

### Added

- Product Scope

### Changed

- Products Scope

### API

#### Added

- ProductsAPI

### Libs

#### Bringer

##### Changed

- BrowserDownloader now downloads/opens a file into a new browser tab

#### Cabinet

##### API

###### Changed

- `fileBlobsFrom(file: FileList)` signature to `fileBlobsFrom(file: FileList?)`

#### Registra

##### SDK

###### Added

- `SignUpFields`
- `SignUpForm`
- `SignUpScopeConfig`
- `SignUpViewModel`
- `VerificationViewModel`

##### API

###### Added

- `SignUpApi` interface
- `SignUpParams`
- `VerificationLinkParams`
- `VerificationParams`

#### Stocker

##### SDK

###### Added

- Products ViewModel
- Product ViewModel
- Product Columns
- MockProduct data class

##### API

###### Added

- StockerAPI interface
- ProductsApi interface
- Inventory interface
- ProductsAPI implementation for pione
- StockerAPI implementation for pione

------------------------------------------------

# 0.01.03

## SDK

### Enhancements

- [ ] Adding View Product Scope
- [ ] Adding Create Product Scope

### Fixes

- [x] Fixed the index out of bound error for Attachments
- [ ] Propagate upload errors properly
- [ ] Migrate `presenters.collections` to from `kotlinx.collections.interoperable` to `kollections.interoperable`

## Api

- [ ]

## Libs

### Cabinet

- [x] Added fileBlobsFrom(file: FileList) method
- [x] Created a proper functions to construct a FileBlob from JS/TS
- [ ] Change fileBlobsFrom(file: FileList) signature to fileBlobsFrom(file: FileList?)

### Koncurrent

####

- Added multistage concurrent progress update on a later object

### Presenters

#### Paginator

- [ ] Add a page loader interface
- [ ] Add a page loader builder
- [ ] No items found triggers whenever any page returns zero.
  e.g. if page no. 2 has zero items, the paginator says there are no items
  while it is clear that there were Items in page 1

## Dependencies

-  [x] Updated kotlin 1.7.10 -> 1.7.20

## Build Scripts

- [x] Made the purify task Configuration Cache Compatible
- [x] Enabled Configuration Cache
- [x] Update gradle 7.5-rc4 -> 7.5.1
- [x] Updated npm publish plugin 2.1.2 -> 3.0.3

# 0.0.93

## SDK

### Fixes

- Swapped the `customerAttachment(customerId)` method, to the `customerAttachment` property

### Enhancements

- Added parallel uploading capability
- Added uploadAttachment to CustomerAttachmentsViewModel
- Added uploadAttachments to CustomerAttachmentsViewModel

## API

### Enhancements

- Customers can now upload multiple attachments at once

## Libs

### Live

### Core

- Made `MutableLive.dispatch`

### Kollections

- Added a new live extension interfacing live and kollections
- Added a `LiveMap` and a `MutableLiveMap`

### Cabinet

#### API Enhancements

- Added `Blob.readBytes(executor)` to the Blob interface
- Added FileBlob implementation
- Added array of file upload params to RootDir interface
- Added implementation of the FakeAPI to reflect the RootDir interface
- Added implementation of the PiOneRootApi to reflect the rootDir interface

### Kollections

- Added interoperable Maps to easily consume mapped like objects from TS/JS

# 0.0.92

## SDK

### New Features

- Introduced `customerAttachements(customerId)` scope
- Added Success toasts so that they are of a different type from info toasts

## API

### New Features

- Added a customer api for managing attachments

## Libs

### Flame

#### Enhancements

- Added getRootDir for customer to manage customer attachments

### Cabinet

### New Features

- Created an abstraction to deal with remote file managements

### Enhancements

- Introduced Blob, ByteArrayBlob, and FakeBlob (for tests)
- Added a pione integration to manage remote files with pione

### Snitch

### Enhancements

- Added makeNewSuccess to the SnitchInterface

# 0.0.91

## SDK

### New Features

#### PiCortexAppScope

- Added toaster: An interface for launching and closing toasts
- Added snacker: An interface for launching and closing snackbars

### Enhancements

#### PiCortexAppScope

- Fixed missing table and list for products scope

## Libs

### New Modules

#### Snitch

A toast,chip and snackbar notification engine

#### Cabinet

A file/attachments manager

### Enhancements

#### Presenters

- Added the location input field

#### Bitframe Sdk Core

- Improved CollectionViewModel to include list and table properties.
  This generalizes tables and lists more

#### Dependencies

- Updated to asoft root version 2.0.13

# 0.0.08

## New Features

### Setrix

- Introduced Setrix: Our settings manager for both business wise and personal preferences
- Can fetch currency setting from pione
- Can resort to a default value on a missing case

### Stocker

- Introduced stoker. Our product & inventory management engine exposed by the StockerApi
- Stocker can load all products from pione
- Can load a product with a specific id
- Can create a basic product with name and description
- Can create a variant for a created product

## Bug Fixes

- Fixed improper generated typescript definition file of the SDK

## Enhancements

- Added the `events-react` module which bring in the `useSubscriber` react hook
- Introducing an experimental flat api to ease interacting with the underlying API
  ```typescript
  // [BEFORE]
  const scope = SDK.scope({ /* . . .*/ })
  scope.api.auth.signIn
  
  // [AFTER]
  const scope = SDK.scope({ /* . . .*/ })
  scope.api.signIn
  ```
- Abstracted parsing and querying to pione endpoint

- Moved the CustomersViewModel into the flame subproject for wider coverage

# 0.0.03

## Bug fixes

- Fixed the `__doNotImplement` type in typescript interfaces

## Enhancements

- Improved working with sign in state api.
  ```
  // [BEFORE]
  import SDK from "@picortex/react"
  import State = SDK.authenticator.signin.SignInState
  
  const {state} = useScope();
  if(state is State.Form) {
    // handle form state
  } else if (State is State.Conundrum) {
    // handle conundrum state
  }
  
  // [AFTER]
  const { state } = useScope();
  
  if(state.isForm) {
    // handle form state
  } else if (state.isConundrum) {
    // handle connundrum
  }
  ```

## Dependencies

| Library/Framework | Previous Version | Current Version |
|:------------------|:-----------------|-----------------|
| bitframe          | 0.10.52          | 0.10.54         |
| authenticator     | 0.0.02           | 0.0.05          |
| kotlin            | 1.6.21           | 1.7.0           |

# 0.0.0

## [flame]

- can create an individual customer with name, email and address

## picortex-signing-api

- Make the sign in feature