// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorCheckMockLocation",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorCheckMockLocation",
            targets: ["CheckMockLocationPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "CheckMockLocationPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/CheckMockLocationPlugin"),
        .testTarget(
            name: "CheckMockLocationPluginTests",
            dependencies: ["CheckMockLocationPlugin"],
            path: "ios/Tests/CheckMockLocationPluginTests")
    ]
)